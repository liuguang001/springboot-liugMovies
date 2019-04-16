package com.lg.movies.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.lg.movies.common.MoviesConsts;
import com.lg.movies.dao.MoviesDao;
import com.lg.movies.dao.MoviesTypeDao;
import com.lg.movies.domain.Movies;
import com.lg.movies.domain.MoviesType;
import com.lg.movies.exception.MovException;
import com.lg.movies.service.MoviesService;
import com.lg.movies.utils.RedisClient;

@Service
public class MoviesServiceImpl implements MoviesService{
	
	@Autowired
	private RedisClient redisClient;
	@Autowired
	private MoviesDao moviesDao;
	@Autowired
	private MoviesTypeDao moviesTypeDao;
	
	/**分页条件查询
	 * @param movies
	 * @return
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public Page<Movies> queryByCondition(Movies movies,Integer pageNo,Integer pageSize){
		Specification<Movies> querySpecifi = new Specification<Movies>() {
			@Override
			public Predicate toPredicate(Root<Movies> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (movies.getTypeId()!=null) {
					 predicates.add(criteriaBuilder.equal(root.get("typeId"), movies.getTypeId()));
				}
				if (movies.getTitle()!=null&&!movies.getTitle().trim().equals("")) {
					 predicates.add(criteriaBuilder.like(root.get("title"), "%"+movies.getTitle()+"%"));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		Page<Movies> page = moviesDao.findAll(querySpecifi,PageRequest.of(pageNo, pageSize));
		redisClient.set("movies",JSON.toJSONString(page));
		return page;
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void saveMovies(Movies movies) throws Exception{
		if (movies==null) {
			throw new MovException("数据为空");
		}
		if (movies.getTitle()==null||movies.getTitle().trim().equals("")) {
			throw new MovException("请填写标题");
		}
		if (movies.getPhotoUrl()==null||movies.getPhotoUrl().trim().equals("")) {
			throw new MovException("请填写封面图地址");
		}
		if (movies.getSourceUrl()==null||movies.getSourceUrl().trim().equals("")) {
			throw new MovException("请填写资源地址");
		}
		if (movies.getTypeId()==null) {
			throw new MovException("请选择资源类型");
		}
		MoviesType moviesType = moviesTypeDao.getOne(movies.getTypeId());
		if (moviesType==null||moviesType.getState()!=MoviesConsts.STATE_VALID) {
			throw new MovException("请选择正确的分类");
		}
		movies.setState(MoviesConsts.STATE_VALID);
		moviesDao.save(movies);
	}
	
}

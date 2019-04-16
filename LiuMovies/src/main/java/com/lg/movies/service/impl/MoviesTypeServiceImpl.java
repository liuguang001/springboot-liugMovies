package com.lg.movies.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lg.movies.common.MoviesConsts;
import com.lg.movies.dao.MoviesTypeDao;
import com.lg.movies.domain.MoviesType;
import com.lg.movies.exception.MovException;
import com.lg.movies.service.MoviesTypeService;

@Service
public class MoviesTypeServiceImpl implements MoviesTypeService {

	@Autowired
	private MoviesTypeDao moviesTypeDao;
	
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(MoviesType moviesType)throws Exception {
		if (moviesType==null) {
			throw new MovException("数据为空!");
		}
		if (moviesType.getTypeName()==null||moviesType.getTypeName().trim().equals("")) {
			throw new MovException("类型名称不能为空!");
		}
		Boolean validTypeName = validTypeName(MoviesConsts.VALID_TYPE_ADD, moviesType.getTypeName(),null);
		if (validTypeName) {
			throw new MovException("类型名称已存在!");
		}
		moviesType.setState(MoviesConsts.STATE_VALID);
		Date date = new Date();
		moviesType.setCreateTime(date);
		moviesType.setUpdateTime(date);
		moviesTypeDao.save(moviesType);
	}
	
	/**
	 * @param type 0新增校验 1修改校验
	 * @param typeName
	 * @param id
	 * @return true:数据库已存在 false:数据库不存在
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public Boolean validTypeName(int type,String typeName,Integer id)throws Exception {
		if (type==0) {
			MoviesType moviesType = moviesTypeDao.findByTypeName(typeName);
			if (moviesType!=null) {
				return true;
			}else {
				return false;
			}
		}else if(type==1){
			MoviesType moviesType = moviesTypeDao.findByTypeName(typeName);
			if (moviesType!=null&&moviesType.getId()!=id.intValue()) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new MovException("验证类型有误!");
		}
	}

	@Override
	public List<MoviesType> listAll() {
		List<MoviesType> moviesTypes=moviesTypeDao.findByState(MoviesConsts.STATE_VALID);
		return moviesTypes;
	}
	
	
}

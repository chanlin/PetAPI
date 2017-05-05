package com.chanlin.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanlin.pet.dao.UserMapper;
import com.chanlin.pet.model.User;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public int addUser(User user) {
		int count = userMapper.insertSelective(user);
		return count;
	}

	public User login() {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(0);
	}

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int updatePwd(String mobile, String password) {
		// TODO Auto-generated method stub
		return userMapper.updatePwdByPhone(mobile, password);
	}

	public List<User> getFriendList(String user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserList(user_id);
	}

	/**
	 * 生成以中心点为中心的四方形经纬度
	 * 
	 * @param lat
	 *            纬度
	 * @param lon
	 *            精度
	 * @param raidus
	 *            半径（以米为单位）
	 * @return
	 */

	public double[] getAround(double lat, double lon, int raidus) {
		Double latitude = lat;
		Double longitude = lon;
		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}
	
	/**  
	     * 计算中心经纬度与目标经纬度的距离（米）  
	     *   
	     * @param centerLon  
	     *            中心精度  
	     * @param centerLan  
	     *            中心纬度  
	     * @param targetLon  
	     *            需要计算的精度  
	     * @param targetLan  
	     *            需要计算的纬度  
	     * @return 米  
	     */    
	    private static double distance(double centerLon, double centerLat, double targetLon, double targetLat) {    
	    
	        double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;    
	        double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;    
	        double b = Math.abs((centerLat - targetLat) * jl_jd);    
	        double a = Math.abs((centerLon - targetLon) * jl_wd);    
	        return Math.sqrt((a * a + b * b));    
	    }   
}



package com.bernie.br.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author
 * @email
 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	private Map<String,Object> dataMap;

	public R() {
		dataMap = new HashMap<>();
		put("code", Constant.HTTP_RES_CODE_200);
		put("msg", Constant.HTTP_RES_CODE_200_VALUE);
	}
	
	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(Constant.HTTP_RES_CODE_500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.clear();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.replace("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {

		return new R();
	}

	@Override
	public R put(String key, Object value) {

		if (this.size()>=2){
			Map<String,Object> map = new HashMap<>();
			map.put(key,value);
			dataMap.put(key,value);
			super.put("data",dataMap);
			return this;
		}
		super.put(key, value);
		return this;
	}
}

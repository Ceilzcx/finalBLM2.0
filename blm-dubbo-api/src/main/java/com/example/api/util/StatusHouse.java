package com.example.api.util;

public class StatusHouse {

	
	public static StatusObject COMMON_STATUS_OK = new StatusObject(StatusCode.CODE_SUCCESS, "success");
	public static StatusObject COMMON_STATUS_DBERROR = new StatusObject(StatusCode.CODE_ERROR, "DBexception");
	public static StatusObject COMMON_STATUS_ALREADYSIGEND = new StatusObject(StatusCode.CODE_ERROR, "already signed");
	public static StatusObject COMMON_STATUS_UNSIGNED = new StatusObject(StatusCode.CODE_ERROR, "unsigned");
	public static StatusObject COMMON_STATUS_NORECORD = new StatusObject(StatusCode.CODE_ERROR, "no record!");
	public static StatusObject COMMON_STATUS_EQUIPMENTUNSIGNED = new StatusObject(StatusCode.CODE_ERROR, "equipment unsigned");
	public static StatusObject COMMON_STATUS_DONTHAVEENOUGHPOINTS = new StatusObject(StatusCode.CODE_ERROR, "dont have enough points");
	public static StatusObject COMMON_STATUS_ERRORINPUTVAR = new StatusObject(StatusCode.CODE_ERROR, "error input");
	public static StatusObject COMMON_STATUS_WRONGPWD = new StatusObject(StatusCode.CODE_ERROR, "wrong pwd");
	public static StatusObject COMMON_STATUS_FLAG = new StatusObject(StatusCode.CODE_ERROR, "flag==0");
	public static StatusObject COMMON_STATUS_USERALREADYCARD = new StatusObject(StatusCode.CODE_ERROR, "user today have record");
	public static StatusObject COMMON_STATUS_IPALREADYCARD = new StatusObject(StatusCode.CODE_ERROR, "IP today have record");
	
	public static StatusObject COMMON_STATUS_TOKENERROR = new StatusObject(StatusCode.CODE_ERROR, "wrong token");
	public static StatusObject COMMON_STATUS_TOKENOVERTIME = new StatusObject(StatusCode.CODE_ERROR, "token overtime");
	
	public static StatusObject COMMON_STATUS_NOCARD = new StatusObject(StatusCode.CODE_ERROR, "no card");

}

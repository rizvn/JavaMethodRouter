package com.rizvn.methodrouter;

/**
 * Created with IntelliJ IDEA.
 * User: riz
 * Date: 08/11/2013
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class Result {
  Integer mCode;
  String mMessage;

  public Result(Integer aCode, String aMessage) {
    mCode = aCode;
    mMessage = aMessage;
  }

  public Result(Integer aCode){
    mCode = aCode;
    mMessage = "";
  }

  public Integer getCode() {
    return mCode;
  }

  public void setCode(Integer aCode) {
    mCode = aCode;
  }

  public String getMessage() {
    return mMessage;
  }

  public void setMessage(String aMessage) {
    mMessage = aMessage;
  }
}

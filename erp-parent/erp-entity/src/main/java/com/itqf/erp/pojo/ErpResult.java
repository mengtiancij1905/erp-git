package com.itqf.erp.pojo;

/**
 * @author 飞鸟
 * @date 2019/7/9 - 16:48
 */
public class ErpResult {
    private String status;
    private String message;
    private Object data;

    public static ErpResult ok(){
        ErpResult result = new ErpResult();
        result.setStatus("ok");
        result.setMessage("执行成功！");
        return result;
    }
    public static ErpResult ok(String message){
        ErpResult result = new ErpResult();
        result.setStatus("ok");
        result.setMessage(message);
        return result;
    }

    public static ErpResult ok(Object data){
        ErpResult result = new ErpResult();
        result.setStatus("ok");
        result.setMessage("执行成功！");
        result.setData(data);
        return result;
    }
    public static ErpResult ok(String message, Object data){
        ErpResult result = new ErpResult();
        result.setStatus("ok");
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static ErpResult notOk(){
        ErpResult result = new ErpResult();
        result.setStatus("not ok");
        result.setMessage("执行失败");
        return result;
    }

    public static ErpResult notOk(String message){
        ErpResult result = new ErpResult();
        result.setStatus("not ok");
        result.setMessage(message);
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

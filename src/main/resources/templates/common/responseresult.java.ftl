package ${chaiPackPath}.common1;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
* 操作消息提醒
*
* @author sws
*/
@Data
public class ResponseResult<T> {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;
    /**
    * 状态码
    */
    public static final String CODE_TAG = "code";

    /**
    * 返回内容
    */
    public static final String MSG_TAG = "msg";

    /**
    * 数据对象
    */
    public static final String DATA_TAG = "data";

    /**
    * 初始化一个新创建的 ResponseResult 对象，使其表示一个空消息。
    */
    public ResponseResult() {
    }

    public ResponseResult(String msg) {
    this.msg = msg;
    }

    /**
    * 初始化一个新创建的 ResponseResult 对象
    *
    * @param code 状态码
    * @param msg  返回内容
    */
    public ResponseResult(int code, String msg) {
    this.code = code;
    this.msg = msg;
    }

    /**
    * 初始化一个新创建的 ResponseResult 对象
    *
    * @param code 状态码
    * @param msg  返回内容
    * @param data 数据对象
    */
    public ResponseResult(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    }

    /**
    * 返回成功消息
    *
    * @return 成功消息
    */
    public static <T> ResponseResult<T> success() {
            return ResponseResult.success("操作成功");
            }

            /**
            * 返回成功数据
            *
            * @return 成功消息
            */
            public static <T> ResponseResult<T> success(T data) {
                    return ResponseResult.success("操作成功", data);
          }

          /**
           * 返回成功消息
           *
           * @param msg 返回内容
           * @return 成功消息
           */
           public static <T> ResponseResult<T> success(String msg) {
            return ResponseResult.success(msg, null);
           }

                            /**
                            * 返回成功消息
                            *
                            * @param msg  返回内容
                            * @param data 数据对象
                            * @return 成功消息
                            */
                            public static <T> ResponseResult<T> success(String msg, T data) {
                                    return new ResponseResult<>(HttpStatus.OK.value(), msg, data);
                                    }

                                    /**
                                    * 返回错误消息
                                    *
                                    * @return 失败消息
                                    */
                                    public static <T> ResponseResult<T> error() {
                                            return ResponseResult.error("操作失败");
                                            }

                                            /**
                                            * 返回错误消息
                                            *
                                            * @param msg 返回内容
                                            * @return 警告消息
                                            */
                                            public static <T> ResponseResult<T> error(String msg) {
                                                    return ResponseResult.error(msg, null);
                                                    }

                                                    /**
                                                    * 返回错误消息
                                                    *
                                                    * @param msg  返回内容
                                                    * @param data 数据对象
                                                    * @return 警告消息
                                                    */
                                                    public static <T> ResponseResult<T> error(String msg, T data) {
                                                            return new ResponseResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
                                                            }

                                                            /**
                                                            * 返回错误消息
                                                            *
                                                            * @param code 状态码
                                                            * @param msg  返回内容
                                                            * @return 警告消息
                                                            */
                                                            public static <T> ResponseResult<T> error(int code, String msg) {
                                                                    return new ResponseResult<>(code, msg, null);
                                                                    }

 }

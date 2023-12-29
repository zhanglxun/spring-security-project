# spring-security-project
spring-security-project

```agsl
https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html
```



## authorization 的使用

- 参考的URL资源

  ```
  https://zhuanlan.zhihu.com/p/538443308
  https://springdoc.cn/spring-authorization-server/getting-started.html#installing-spring-authorization-server
  https://blog.csdn.net/weixin_42229668/article/details/132912917
  https://blog.csdn.net/weixin_42229668/article/details/132925597
  ```

  

- 请求发起，获取code

  ```
  http://127.0.0.1:9001/oauth2/authorize?response_type=code&client_id=messaging-client&scope=message.read&redirect_uri=http://127.0.0.1:9001/authorized
  ```

  

- 根据code 或者token

  ```
   postman
   http://127.0.0.1:9001/oauth2/token
  ```

  - Authorization：base auth，需要填 username、password
  - body: form-data,填写参数：grant_type、code、redirect_uri ，code 只能用一次

  

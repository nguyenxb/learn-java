package com.nguyenxb.boot.converter;

import com.nguyenxb.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class NguyenMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    // 当 传入的数据类型是 person类时, 开放写入权限.
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /*
        服务器要统计所有MessageConverter 都能写出哪些内容类型
         服务器调用这个方法后 会知道可以写出 这个类型 application/x-nguyen 的数据.
    *
    * */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-nguyen");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return null;
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议将数据写出.
        String data = person.getId()+";"+person.getName()+";"+person.getAge()+";"+person.getEmail()+";";
        // 将数据写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}

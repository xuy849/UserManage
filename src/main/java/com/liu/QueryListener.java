package com.liu;

import com.liu.event.QueryEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuneng on 2016/12/28.
 */
@Component
public class QueryListener implements ApplicationListener<QueryEvent> {
    @Override
    public void onApplicationEvent(QueryEvent event) {
        System.out.println(event.getMessage());
    }
}

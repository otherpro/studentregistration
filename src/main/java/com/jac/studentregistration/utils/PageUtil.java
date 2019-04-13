package com.jac.studentregistration.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author Jac
 * @date 2019-03-30 13:07
 */
public class PageUtil {
    public static Pageable PageBuild(Pageable pageable){
        return PageRequest.of(pageable.getPageNumber()-1,pageable.getPageSize());
    }
    public static Pageable pageBuild(Pageable pageable,Sort sort){
        return PageRequest.of(pageable.getPageNumber()-1,pageable.getPageSize(),sort);
    }
}

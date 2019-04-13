package com.jac.studentregistration.dao;


import com.jac.studentregistration.entity.SuccessKilled;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.apache.ibatis.annotations.Param;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */
public interface SuccessKilledDao extends JpaRepository<SuccessKilled, String> {

    /**
     * 插入购买明细,可过滤重复
     * @param seckillId
     * @param userPhone
     * @return插入的行数
     */
    int insertSuccessKilled(long seckillId, long userPhone);
//    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


    /**
     * 根据秒杀商品的id查询明细SuccessKilled对象(该对象携带了Seckill秒杀产品对象)
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId, long userPhone);
//    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}

package com.example.AEPB;



/*
 1、
 * given 空的停车场和一辆想要存的车
 * when 存车
 * then 存车成功给予存车票
 2、
 * * given 存有50辆车的停车场和一辆想存的车
 * when 存车
 * then 存车失败没有存车票
 3、
 * given 存有49辆车的停车场和一辆想要存的车
 * when 存车
 * then 存车成功并拿到存车票
 4、
 * given 空的停车场和我没有车
 * when 存车
 * then 存车失败抛出异常
 5、
 * given 有车的停车场和一张存车票
 * when 取车
 * then 取车成功并开出车
 6、
 * given 空的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 7、
 * given 有车的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 8、
 * given 有辆车的停车场和我没票
 * when 取车
 * then 取车失败抛出异常
 *
 * */
public class ParkingLotTest {
}

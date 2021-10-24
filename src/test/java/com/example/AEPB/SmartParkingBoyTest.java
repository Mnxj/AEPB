package com.example.AEPB;

/*
 * given 1号停车场停有1辆车，其他停车场为空，smart Parking boy，一辆车
 * when 停车
 * then 停车成功并获得车票，停在了2号停车位
 *
 * given 都是空停车场，smart boy，一辆车
 * when 停车
 * then  停车成功并获得车票，停在了1号停车位
 *
 * given 都是满停车场，smart boy，一辆车
 * when 停车
 * then  停车失败并抛异常
 *
 * given 一张有效车票，smart boy
 * when 取车
 * then  取车成功
 *
 * given 一张无效车票，smart boy
 * when 取车
 * then  取车失败
 *
*/

import org.junit.jupiter.api.Test;

public class SmartParkingBoyTest {
}

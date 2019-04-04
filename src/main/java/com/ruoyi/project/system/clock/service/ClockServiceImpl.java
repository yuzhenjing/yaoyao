package com.ruoyi.project.system.clock.service;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.clock.domain.Clock;
import com.ruoyi.project.system.clock.mapper.ClockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工考勤 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ClockServiceImpl implements IClockService {
    @Autowired
    private ClockMapper clockMapper;

    /**
     * 查询员工考勤信息
     *
     * @param clockId 员工考勤ID
     * @return 员工考勤信息
     */
    @Override
    public Clock selectClockById(Integer clockId) {
        return clockMapper.selectClockById(clockId);
    }

    /**
     * 查询员工考勤列表
     *
     * @param clock 员工考勤信息
     * @return 员工考勤集合
     */
    @Override
    public List<Clock> selectClockList(Clock clock) {
        return clockMapper.selectClockList(clock);
    }

    /**
     * 新增员工考勤
     *
     * @param clock 员工考勤信息
     * @return 结果
     */
    @Override
    public int insertClock(Clock clock) {
        return clockMapper.insertClock(clock);
    }

    /**
     * 修改员工考勤
     *
     * @param clock 员工考勤信息
     * @return 结果
     */
    @Override
    public int updateClock(Clock clock) {


        return clockMapper.updateClock(clock);
    }

    /**
     * 删除员工考勤对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClockByIds(String ids) {
        return clockMapper.deleteClockByIds(Convert.toStrArray(ids));
    }

}

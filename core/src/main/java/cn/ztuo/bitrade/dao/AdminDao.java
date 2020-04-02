package cn.ztuo.bitrade.dao;

import cn.ztuo.bitrade.dao.base.BaseDao;
import cn.ztuo.bitrade.entity.Admin;
import cn.ztuo.bitrade.entity.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Seven
 * @date 2019年12月18日
 */
public interface AdminDao extends BaseDao<Admin> {

    Admin findAdminByUsernameAndPassword(String username, String password);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Admin a set a.lastLoginTime=?1,a.lastLoginIp=?2 where a.id=?3")
    int updateAdminLastTimeAndIp(Date date, String ip, Long memberId);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("delete from Admin a where a.roleId = ?1")
    int deleteBatch(Long roleId);

    List<Admin> findAllByDepartment(Department department);

    List<Admin> findAllByRoleId(long id);

    Admin findByUsername(String username);

    List<Admin> findByMobilePhone(String mobilePhone);
}

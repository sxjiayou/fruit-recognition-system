package com.ruoyi.utrain.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.utrain.domain.User;
import com.ruoyi.utrain.service.IUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userController
 * 
 * @author sx
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/utrain/user")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    /**
     * 查询user列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出user列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:export')")
    @Log(title = "user", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        util.exportExcel(response, list, "user数据");
    }

    /**
     * 获取user详细信息
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userService.selectUserById(id));
    }

    /**
     * 新增user
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:add')")
    @Log(title = "user", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改user
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:edit')")
    @Log(title = "user", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除user
     */
    //@PreAuthorize("@ss.hasPermi('utrain:user:remove')")
    @Log(title = "user", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }
}

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
import com.ruoyi.utrain.domain.Ap;
import com.ruoyi.utrain.service.IApService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * apController
 * 
 * @author sx
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/utrain/ap")
public class ApController extends BaseController
{
    @Autowired
    private IApService apService;

    /**
     * 查询ap列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:list')")
    @GetMapping("/list")
    public TableDataInfo list(Ap ap)
    {
        startPage();
        List<Ap> list = apService.selectApList(ap);
        return getDataTable(list);
    }

    /**
     * 导出ap列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:export')")
    @Log(title = "ap", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Ap ap)
    {
        List<Ap> list = apService.selectApList(ap);
        ExcelUtil<Ap> util = new ExcelUtil<Ap>(Ap.class);
        util.exportExcel(response, list, "ap数据");
    }

    /**
     * 获取ap详细信息
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(apService.selectApById(id));
    }

    /**
     * 新增ap
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:add')")
    @Log(title = "ap", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Ap ap)
    {
        return toAjax(apService.insertAp(ap));
    }

    /**
     * 修改ap
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:edit')")
    @Log(title = "ap", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Ap ap)
    {
        return toAjax(apService.updateAp(ap));
    }

    /**
     * 删除ap
     */
    //@PreAuthorize("@ss.hasPermi('utrain:ap:remove')")
    @Log(title = "ap", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(apService.deleteApByIds(ids));
    }
}

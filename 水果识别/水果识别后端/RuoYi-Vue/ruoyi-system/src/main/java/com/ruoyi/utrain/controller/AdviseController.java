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
import com.ruoyi.utrain.domain.Advise;
import com.ruoyi.utrain.service.IAdviseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * adviseController
 * 
 * @author sx
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/utrain/advise")
public class AdviseController extends BaseController
{
    @Autowired
    private IAdviseService adviseService;

    /**
     * 查询advise列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:list')")
    @GetMapping("/list")
    public TableDataInfo list(Advise advise)
    {
        startPage();
        List<Advise> list = adviseService.selectAdviseList(advise);
        return getDataTable(list);
    }

    /**
     * 导出advise列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:export')")
    @Log(title = "advise", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Advise advise)
    {
        List<Advise> list = adviseService.selectAdviseList(advise);
        ExcelUtil<Advise> util = new ExcelUtil<Advise>(Advise.class);
        util.exportExcel(response, list, "advise数据");
    }

    /**
     * 获取advise详细信息
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(adviseService.selectAdviseById(id));
    }

    /**
     * 新增advise
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:add')")
    @Log(title = "advise", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Advise advise)
    {
        return toAjax(adviseService.insertAdvise(advise));
    }

    /**
     * 修改advise
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:edit')")
    @Log(title = "advise", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Advise advise)
    {
        return toAjax(adviseService.updateAdvise(advise));
    }

    /**
     * 删除advise
     */
    //@PreAuthorize("@ss.hasPermi('utrain:advise:remove')")
    @Log(title = "advise", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adviseService.deleteAdviseByIds(ids));
    }
}

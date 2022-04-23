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
import com.ruoyi.utrain.domain.Sportdata;
import com.ruoyi.utrain.service.ISportdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * sportdataController
 * 
 * @author sx
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/utrain/sportdata")
public class SportdataController extends BaseController
{
    @Autowired
    private ISportdataService sportdataService;

    /**
     * 查询sportdata列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sportdata sportdata)
    {
        startPage();
        List<Sportdata> list = sportdataService.selectSportdataList(sportdata);
        return getDataTable(list);
    }

    /**
     * 导出sportdata列表
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:export')")
    @Log(title = "sportdata", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sportdata sportdata)
    {
        List<Sportdata> list = sportdataService.selectSportdataList(sportdata);
        ExcelUtil<Sportdata> util = new ExcelUtil<Sportdata>(Sportdata.class);
        util.exportExcel(response, list, "sportdata数据");
    }

    /**
     * 获取sportdata详细信息
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:query')")
    @GetMapping(value = "/{qid}")
    public AjaxResult getInfo(@PathVariable("qid") Long qid)
    {
        return AjaxResult.success(sportdataService.selectSportdataByQid(qid));
    }

    /**
     * 新增sportdata
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:add')")
    @Log(title = "sportdata", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sportdata sportdata)
    {
        return toAjax(sportdataService.insertSportdata(sportdata));
    }

    /**
     * 修改sportdata
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:edit')")
    @Log(title = "sportdata", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sportdata sportdata)
    {
        return toAjax(sportdataService.updateSportdata(sportdata));
    }

    /**
     * 删除sportdata
     */
    //@PreAuthorize("@ss.hasPermi('utrain:sportdata:remove')")
    @Log(title = "sportdata", businessType = BusinessType.DELETE)
	@DeleteMapping("/{qids}")
    public AjaxResult remove(@PathVariable Long[] qids)
    {
        return toAjax(sportdataService.deleteSportdataByQids(qids));
    }
}

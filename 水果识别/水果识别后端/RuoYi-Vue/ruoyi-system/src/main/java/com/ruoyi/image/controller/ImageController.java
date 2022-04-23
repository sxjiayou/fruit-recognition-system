package com.ruoyi.image.controller;

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
import com.ruoyi.image.domain.Image;
import com.ruoyi.image.service.IImageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * imageController
 * 
 * @author sx
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/image/image")
public class ImageController extends BaseController
{
    @Autowired
    private IImageService imageService;

    /**
     * 查询image列表
     */
    //@PreAuthorize("@ss.hasPermi('image:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(Image image)
    {
        startPage();
        List<Image> list = imageService.selectImageList(image);
        return getDataTable(list);
    }

    /**
     * 导出image列表
     */
    //@PreAuthorize("@ss.hasPermi('image:image:export')")
    @Log(title = "image", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Image image)
    {
        List<Image> list = imageService.selectImageList(image);
        ExcelUtil<Image> util = new ExcelUtil<Image>(Image.class);
        util.exportExcel(response, list, "image数据");
    }

    /**
     * 获取image详细信息
     */
    //@PreAuthorize("@ss.hasPermi('image:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(imageService.selectImageById(id));
    }

    /**
     * 新增image
     */
    //@PreAuthorize("@ss.hasPermi('image:image:add')")
    @Log(title = "image", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Image image)
    {
        return toAjax(imageService.insertImage(image));
    }

    /**
     * 修改image
     */
    //@PreAuthorize("@ss.hasPermi('image:image:edit')")
    @Log(title = "image", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Image image)
    {
        return toAjax(imageService.updateImage(image));
    }

    /**
     * 删除image
     */
    //@PreAuthorize("@ss.hasPermi('image:image:remove')")
    @Log(title = "image", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imageService.deleteImageByIds(ids));
    }
}

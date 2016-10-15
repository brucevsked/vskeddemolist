package com.etop.basic.controller;

import com.etop.utils.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created by Jeremie on 14-2-12.
 */

public abstract class BaseController {

    public final static String ERROR = "error";
    public final static String SUCCESS = "success";
    
    protected Logger log = Logger.getLogger(this.getClass());

    /**
     * 添加Model消息
     *
     * @param messages
     */
    protected void addMessage(Model model, String messages) {
        model.addAttribute("message", messages);
    }
    
    /**
     * 添加Model消息
     * @param type 消息类型
     * @param messages
     */
    protected void addMessage(Model model,String type, String messages) {
        model.addAttribute("message", messages);
        model.addAttribute("type", type);
    }

    /**
     * 添加Flash消息
     *
     * @param messages
     */
    protected void addMessage(RedirectAttributes redirectAttributes, String messages) {
        redirectAttributes.addFlashAttribute("message", messages);
    }
    
    /**
     * 添加Flash消息
     * @param type 消息类型
     * @param messages
     */
    protected void addMessage(RedirectAttributes redirectAttributes, String type, String messages) {
        redirectAttributes.addFlashAttribute("message", messages);
        redirectAttributes.addFlashAttribute("type", type);
    }

    /**
     * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                //setValue(text == null ? null : StringEscapeUtils.escapeHtml(text.trim()));
                setValue(text == null ? null : text.trim());
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request){
        log.error("系统发生异常", ex);
        ex.printStackTrace();
        request.setAttribute("exMsg", ex.getMessage());
        return "errors/exception";
    }
}

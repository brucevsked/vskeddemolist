package com.vsked.test.jdk;

public record MenuRecord(
        Long id,
        String name,
        Integer type, // 建议使用 Integer 以兼容 null
        String url,
        Long parent_id,
        String component,
        String componentName,
        String icon,
        Boolean hidden,
        Boolean alwaysShow,
        Boolean noCache,
        Boolean breadcrumb,
        Boolean affix,
        Boolean noTagsView,
        Boolean activeMenu,
        Boolean canTo
) {
    // 辅助构造器：只接受 id 和 name，其他字段设为 null
    public MenuRecord(Long id, String name) {
        this(id, name, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}

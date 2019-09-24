<div class="sidebar animated fadeInDown">
    <div class="logo-title">
        <div class="title">
            <img src="${options.blog_logo!'${static!}/source/images/logo@2x.png'}"
                 style="width:127px;<#if settings.avatar_circle!false>border-radius:50%</#if>"/>
            <h3 title="">
                <a href="${context!}">${options.blog_title!'Anatole'}</a>
            </h3>
            <div class="description">
                <#if settings.hitokoto!false>
                    <p id="yiyan">获取中...</p>
                <#else >
                    <p>${user.description!'A other Halo theme'}</p>
                </#if>
            </div>
        </div>
    </div>
    <#include "social-list.ftl">
    <div class="footer">
        <a target="_blank" href="#">
            <#-- 不允许修改该主题信息，也不能删除。 -->
            <span>Designed by </span>
            <a href="https://www.caicai.me">CaiCai</a>
            <div class="by_halo">
                <a href="https://github.com/halo-dev/halo" target="_blank">href="https://www.caicai.me"</a>
            </div>
            <div class="footer_text">
                <@common.footer_info />
                © 2018-2019 wljun.com 版权所有 ICP证：鄂ICP备18007886号-1
            </div>
        </a>
    </div>
</div>

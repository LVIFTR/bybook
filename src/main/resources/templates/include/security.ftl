<#assign known = Session.SPRING_SECURITY_CONTEXT?? >

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getNickname()
    fullName = user.getFirstName() + " " + user.getLastName() + " | " + user.getNickname()
    ROLE = user.getRole()
    >
<#else>
    <#assign name = "N/A" fullName = "N/A" ROLE = "USER">
</#if>
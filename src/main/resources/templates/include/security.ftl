<#assign known = Session.SPRING_SECURITY_CONTEXT?? >

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getNickname()
    fullName = user.getFirstName() + " " + user.getLastName() + " | " + user.getNickname()
    >
<#else>
    <#assign name = "" fullName = "">
</#if>
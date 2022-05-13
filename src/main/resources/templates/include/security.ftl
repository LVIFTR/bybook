<#assign known = Session.SPRING_SECURITY_CONTEXT?? >

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getNickname()
        fullName = user.getFirstName() + " " + user.getLastName() + " | " + user.getNickname()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign name = "N/A" fullName = "N/A" isAdmin = false>
</#if>
<c:forEach var="i" begin="1" end="5">
    Item <c:out value="${1}"/><p>
</c:forEach>

Item 1
Item 2
Item 3
Item 4
Item 5

<c: forTokens items="google, runoob, taobao" delims="," var="name">
    <c:out value="${name}"/><p>
</c:forTokens>

google
runoob
taobao
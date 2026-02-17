<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Warranty Years</h3>

    <c:choose>
        <c:when test="${empty warrantyYears}">
            <div class="warranty-empty">
                Contact about detail information.
            </div>
        </c:when>

        <c:otherwise>
           <div class="warranty-number">
               ${warrantyYears}
           </div>
        </c:otherwise>
    </c:choose>

</div>

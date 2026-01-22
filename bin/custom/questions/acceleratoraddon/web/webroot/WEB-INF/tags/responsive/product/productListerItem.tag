<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<spring:theme code="text.addToCart" var="addToCartText"/>
<c:url value="${product.url}" var="productUrl"/>

<c:set value="${not empty product.potentialPromotions}" var="hasPromotion"/>

<c:set value="product__list--item" var="productTagClasses"/>
<c:forEach var="tag" items="${product.tags}">
    <c:set value="${productTagClasses} tag-${tag}" var="productTagClasses"/>
</c:forEach>

<li class="${fn:escapeXml(productTagClasses)}">
    <ycommerce:testId code="test_searchPage_wholeProduct">
        <a class="product__list--thumb" href="${fn:escapeXml(productUrl)}" title="${fn:escapeXml(product.name)}">
            <product:productPrimaryImage product="${product}" format="thumbnail"/>
        </a>
        <ycommerce:testId code="searchPage_productName_link_${product.code}">
            <a class="product__list--name"
               href="${fn:escapeXml(productUrl)}">${ycommerce:sanitizeHTML(product.name)}</a>
        </ycommerce:testId>

        <div class="product__list--price-panel">
            <c:if test="${not empty product.potentialPromotions}">
                <div class="product__listing--promo">
                    <c:forEach items="${product.potentialPromotions}" var="promotion">
                        ${ycommerce:sanitizeHTML(promotion.description)}
                    </c:forEach>
                </div>
            </c:if>

            <ycommerce:testId code="searchPage_price_label_${product.code}">
                <div class="product__listing--price"><product:productListerItemPrice product="${product}"/>

                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M17 9H7V7H17V9Z" fill="currentColor"></path>
                        <path d="M7 13H17V11H7V13Z" fill="currentColor"></path>
                        <path
                                fill-rule="evenodd"
                                clip-rule="evenodd"
                                d="M2 18V2H22V18H16V22H14C11.7909 22 10 20.2091 10 18H2ZM12 16V18C12 19.1046 12.8954 20 14 20V16H20V4H4V16H12Z"
                                fill="currentColor">
                        </path>
                    </svg>

                    <span class="product__listing--question-count">
                            ${not empty product.questionCount ? product.questionCount : 0}
                    </span>
                </div>
            </ycommerce:testId>
        </div>

        <c:if test="${not empty product.summary}">
            <div class="product__listing--description">${ycommerce:sanitizeHTML(product.summary)}</div>
        </c:if>

        <c:set var="product" value="${product}" scope="request"/>
        <c:set var="addToCartText" value="${addToCartText}" scope="request"/>
        <c:set var="addToCartUrl" value="${addToCartUrl}" scope="request"/>
        <div class="addtocart">
            <div id="actions-container-for-${fn:escapeXml(component.uid)}" class="row">
                <action:actions element="div" parentComponent="${component}"/>
            </div>
        </div>

    </ycommerce:testId>
</li>








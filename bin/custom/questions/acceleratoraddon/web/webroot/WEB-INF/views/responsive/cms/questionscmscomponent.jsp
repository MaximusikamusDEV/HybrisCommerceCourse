<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="question-component"
     style="<c:if test='${fontSize ne null}'>font-size:${fontSize}px;</c:if> ">
<h3>Questions & Answers</h3>

    <c:choose>
        <c:when test="${empty questions}">
            <div class="questions-empty">
                No questions yet.
            </div>
        </c:when>

        <c:otherwise>
            <ul class="questions-list">
                <c:forEach items="${questions}" var="q">
                    <li class="question-item">
                        <div class="question-text">
                            <strong>Question: </strong>
                            <c:out value="${q.question}"/>
                        </div>

                        <c:if test="${not empty q.questionCustomer}">
                            <div class="answer-meta">
                                Asked by: <c:out value="${q.questionCustomer}" />
                            </div>
                        </c:if>

                        <div class="answer-text">
                            <strong>Answer: </strong>

                            <c:choose>
                                <c:when test="${empty q.answer}">
                                    No answer yet
                                </c:when>

                                <c:otherwise>
                                <c:out value="${q.answer}" />
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <c:if test="${not empty q.answerCustomer}">
                            <div class="answer-meta">
                                Answered by: <c:out value="${q.answerCustomer}" />
                            </div>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>

</div>

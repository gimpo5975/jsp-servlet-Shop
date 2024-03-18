<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="./css/reset.css" rel="stylesheet" />
    <link rel="stylesheet" href="./css/index.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
      integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
  </head>

  <body>
    <!-- container-->
    <div class="container">
      <!-- header-->
      <div class="header">
        <h1 class="admin"><a href="./index_jyp.html">ADMINISTRATOR</a></h1>
        <!--logo-->
        <img
          class="mainlogo"
          src="./images/logo.png"
          alt="This is PeplCore logo"
        />
        <!--topNav-->
        <div class="topNav">
          <ul>
            <li>
              <a href="#">
                <i class="fa-solid fa-store fa-lg"></i>&nbsp;&nbsp;
              </a>
            </li>
            <li><a href="#"> <i class="fa-solid fa-arrow-right-from-bracket"></i>&nbsp;로그아웃</a></li>
          </ul>
          <!--end of topNav-->
        </div>
        <!--end of header-->
      </div>
      <!-- 왼쪽 사이드바 메뉴, 아코디언 사용할거임 -->
      <div class="leftmain">
        <ul class="sideMenu">
          <!-- 회원 관리 -->
          <li>
            <div
              class="accordion-header userhr"
              onclick="ToggleAccordion(this)"
            >
              회원 관리
            </div>
            <div class="accordion-content">
              <!--display:none-->
              <p><a href="#">회원 관리</a></p>
            </div>
          </li>
          <!-- 상품 관리 -->
          <li>
            <div class="accordion-header" onclick="ToggleAccordion(this)">
              <a href="./productManagement.html">상품 관리</a>
            </div>
            <!--display:none-->
            <div class="accordion-content">
              <p><a href="./productManagement.html">상품 목록</a></p>
            </div>
          </li>
          <!-- 게시글 관리 -->
          <li>
            <div class="accordion-header"onclick="ToggleAccordion(this)">
              게시글 관리
            </div>
            <!--display:none-->
            <div class="accordion-content">
              <p><a href="#">공지사항</a></p>
              <p><a href="#">FAQ</a></p>
              <p><a href="#">QnA</a></p>
              <p><a href="#">review</a></p>
            </div>
          </li>
        </ul>
        <!-- end of leftmain-->
      </div>

      <!-- main-->
      <div class="main">
        <!--maincontent-->
        <div class="maincontent">
          <h3>관리자 메인</h3>
          <hr />
          <!-- 신규 가입 회원-->
          <h4>신규 가입 회원</h4>
          <br />
          이 부분은 jsp으로 구현해야 하는데 일단 보여주기는 해야 하니까 그냥
          테이블로 만들었습니다.
          <table style="width: 500px;height: 100px;text-align: center;">
            <tr>
              <th>이름</th>
              <th>ID</th>
              <th>전화번호</th>
              <th>가입일</th>
              <th>등급</th>
            </tr>
            <tr>
              <td>이름1</td>
              <td>ID1</td>
              <td>전화번호1</td>
              <td>가입일1</td>
              <td>등급1</td>
            </tr>
            <tr>
              <td>이름2</td>
              <td>ID2</td>
              <td>전화번호2</td>
              <td>가입일2</td>
              <td>등급2</td>
            </tr>
            <tr>
              <td>이름3</td>
              <td>ID3</td>
              <td>전화번호3</td>
              <td>가입일3</td>
              <td>등급3</td>
            </tr>
          </table>
          <hr class="lasthr" />
          <!-- 최근 게시물 목록-->
          <h4>최근 게시물 목록</h4>
          <br />
          이 부분은 jsp으로 구현해야 하는데 일단 보여주기는 해야 하니까 그냥
          테이블로 만들었습니다.
          <table style="width: 500px;height: 100px;text-align: center;">
            <tr>
              <th>게시판</th>
              <th>제목</th>
              <th>ID</th>
              <th>작성일자</th>
            </tr>
            <tr>
              <td>게시판</td>
              <td>제목</td>
              <td>ID</td>
              <td>작성일자</td>
            </tr>
            <tr>
              <td>게시판</td>
              <td>제목</td>
              <td>ID</td>
              <td>작성일자</td>
            </tr>
            <tr>
              <td>게시판</td>
              <td>제목</td>
              <td>ID</td>
              <td>작성일자</td>
            </tr>
          </table>
        </div>
        <!-- end of maincontent-->
      </div>
      <!--end of main-->

      <!--footer-->
      <div class="Footer">
        <p>Copyright &copy; 주식회사 불사조 All Rights Reserved</p>
      </div>
      <!--end of footer-->
    </div>
    <!-- end of container -->

    <!-- 아코디언 js 코드 -->
    <script>
      function ToggleAccordion(sideMenu) {
        var content = sideMenu.nextElementSibling;
        if (content.style.display === "block") {
          content.style.display = "none";
        } else {
          content.style.display = "block";
        }
      }
    </script>
  </body>
</html>

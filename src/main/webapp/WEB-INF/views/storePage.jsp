<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>The Krusty Krab</title>
    <%@include file="main/csslink.jsp" %>
    <link rel="stylesheet" href="/resources/css/menu/store.css">
</head>
<body>
<header>
    <jsp:include page="main/header.jsp"/>
</header>
<div id="bg"></div>
<main style=" width:1440px; height: 900px; margin: 0 auto;">
    <div id="map" style="width:100%;height:100%; margin: 0 auto;"></div>
</main>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bb5a8f867f43c670b360f3bff1cf1359"></script>
<script>
    // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
    var infowindow = new kakao.maps.InfoWindow({zIndex:1});

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.5000326, 126.8680013), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    var imageSrc = '/resources/img/logo.png', // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(50, 50) // 마커이미지의 크기입니다

    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);


    // 키워드 검색 완료 시 호출되는 콜백함수 입니다
    function placesSearchCB (data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
            // LatLngBounds 객체에 좌표를 추가합니다
            var bounds = new kakao.maps.LatLngBounds();

            for (var i=0; i<data.length; i++) {
                displayMarker(data[i]);
                bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            }

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
            map.setBounds(bounds);
        }
    }

    <c:forEach var="s" items="${stores}">
    place =
        {
            y: ${s.storeLatitude},
            x: ${s.storeLongitude},
            place_name: '${s.storeName}',
            place_tel: '${s.storeTelNumber}',
            place_id: '${s.storeId}'
        };
    displayMarker(place);
    </c:forEach>

    // 지도에 마커를 표시하는 함수입니다
    function displayMarker(place) {

        // 마커를 생성하고 지도에 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x),
            image:  markerImage
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'click', function() {
            // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
            infowindow.setContent('<div style="padding:5px;font-size:12px;">'
                + place.place_name +'<br>' + place.place_tel + '' +
                '<br><button onclick="location.href=\'/order/' + place.place_id + '\'"'  + '>주문하기</button>' +
                '</div>');
            infowindow.open(map, marker);
        });
    }
</script>
</body>
</html>
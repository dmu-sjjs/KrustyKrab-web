<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<main id="mainpage">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators" style="z-index: 1">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <a href="#"><img src="/resources/img/main/banner.jpg" class="d-block w-100" alt="..."></a>
            </div>
            <div class="carousel-item">
                <a href="#"><img src="/resources/img/main/banner.jpg" class="d-block w-100" alt="..."></a>
            </div>
            <div class="carousel-item">
                <a href="#"><img src="/resources/img/main/banner.jpg" class="d-block w-100" alt="..."></a>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div id="youtube">
        <iframe width="960" height="400" src="https://www.youtube.com/embed/MlNndKvXa80" title="게살버거 1시간" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>    </div>

    <div id="sns">
        <audio autoplay loop controls>
            <source src="/resources/audio/opening.mp3" type="audio/mp3">
        </audio>
        <br><h1 id="snstitle">Krusty Krab</h1>
        <ul class="snslist">
            <li><a href="#"><img width="80px" height="80px" src="/resources/img/main/youtube.png" /></a> Youtube</li>
            <li><a href="#"><img width="80px" height="80px" src="/resources/img/main/instagram.png" /></a> Instagram</li>
            <li><a href="#"><img width="80px" height="80px" src="/resources/img/main/facebook.jpg" /></a> Facebook</li>
        </ul>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

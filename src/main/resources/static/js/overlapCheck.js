
const overlap = document.querySelector("#overlap");
const id = document.querySelector('#joinId');

overlap.addEventListener('click', bringId)

function bringId() {
    const checkId = id.value;
    if (checkId === ""){
        alert('아이디를 입력하세요');
    }else{
        window.open("/", "아이디 중복 확인","width=500,height=300");
    }
}
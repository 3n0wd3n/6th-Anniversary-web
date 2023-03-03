//select DOM
btn_1 = document.querySelector('.btn-1');
btn_2 = document.querySelector('.btn-2');
btn_3 = document.querySelector('.btn-3');
btn_4 = document.querySelector('.btn-4');
btn_5 = document.querySelector('.btn-5');
btn_6 = document.querySelector('.btn-6');

activitie_1 = document.querySelector('.activitie-1');
activitie_2 = document.querySelector('.activitie-2');
activitie_3 = document.querySelector('.activitie-3');
activitie_4 = document.querySelector('.activitie-4');
activitie_5 = document.querySelector('.activitie-5');
activitie_6 = document.querySelector('.activitie-6');

//event listeners
btn_1.addEventListener('click', open_activitie_1);
btn_2.addEventListener('click', open_activitie_2);
btn_3.addEventListener('click', open_activitie_3);
btn_4.addEventListener('click', open_activitie_4);
btn_5.addEventListener('click', open_activitie_5);
btn_6.addEventListener('click', open_activitie_6);

function open_activitie_1(){
    console.log("btn1");
    activitie_1.style.display = "flex";
    activitie_2.style.display = "none";
    activitie_3.style.display = "none";
    activitie_4.style.display = "none";
    activitie_5.style.display = "none";
    activitie_6.style.display = "none";
}

function open_activitie_2(){
    console.log("btn2");
    activitie_1.style.display = "none";
    activitie_2.style.display = "flex";
    activitie_3.style.display = "none";
    activitie_4.style.display = "none";
    activitie_5.style.display = "none";
    activitie_6.style.display = "none";
}

function open_activitie_3(){
    console.log("btn3");
    activitie_1.style.display = "none";
    activitie_2.style.display = "none";
    activitie_3.style.display = "flex";
    activitie_4.style.display = "none";
    activitie_5.style.display = "none";
    activitie_6.style.display = "none";
}

function open_activitie_4(){
    console.log("btn4");
    activitie_1.style.display = "none";
    activitie_2.style.display = "none";
    activitie_3.style.display = "none";
    activitie_4.style.display = "flex";
    activitie_5.style.display = "none";
    activitie_6.style.display = "none";
}

function open_activitie_5(){
    console.log("btn5");
    activitie_1.style.display = "none";
    activitie_2.style.display = "none";
    activitie_3.style.display = "none";
    activitie_4.style.display = "none";
    activitie_5.style.display = "flex";
    activitie_6.style.display = "none";
}

function open_activitie_6(){
    console.log("btn6");
    activitie_1.style.display = "none";
    activitie_2.style.display = "none";
    activitie_3.style.display = "none";
    activitie_4.style.display = "none";
    activitie_5.style.display = "none";
    activitie_6.style.display = "flex";
}

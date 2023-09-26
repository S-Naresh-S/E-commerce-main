const branda=document.getElementById('a');
const brandb=document.getElementById('b');
const brandc=document.getElementById('c');
const brand=document.getElementsByClassName('A');
const brand1=document.getElementsByClassName('B');
const brand2=document.getElementsByClassName('C');
branda.addEventListener('click', ()=>{
    for(let i=0;i<brand1.length;i++){
        brand1[i].style.display='none';
    }
    for(let i=0;i<brand2.length;i++){
        brand2[i].style.display='none';
    }
    for(let i=0;i<brand.length;i++){
        brand[i].style.display='block';
    }
});
brandb.addEventListener('click', ()=>{
    for(let i=0;i<brand1.length;i++){
        brand1[i].style.display='block';
    }
    for(let i=0;i<brand2.length;i++){
        brand2[i].style.display='none';
    }
    for(let i=0;i<brand.length;i++){
        brand[i].style.display='none';
    }});
brandc.addEventListener('click', ()=>{
    for(let i=0;i<brand1.length;i++){
        brand1[i].style.display='none';
    }
    for(let i=0;i<brand2.length;i++){
        brand2[i].style.display='block';
    }
    for(let i=0;i<brand.length;i++){
        brand[i].style.display='none';
    }});
const all=document.getElementById('all');
all.addEventListener('click', ()=>{
    for(let i=0;i<brand1.length;i++){
        brand1[i].style.display='block';
    }
    for(let i=0;i<brand2.length;i++){
        brand2[i].style.display='block';
    }
    for(let i=0;i<brand.length;i++){
        brand[i].style.display='block';
}});

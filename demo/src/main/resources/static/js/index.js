function addItemCard(item){
    const innerhtml='<div id="items" class="'+item.brand+'">\n'+
    '<img src="'+item.img+'" alt="image">\n'+
    '<h2 class="title">'+item.name+'</h2>\n'+
    '<h3 class="title">Brand: '+item.brand+'</h3>\n'+
    '<p class="text" samesite="none">'+item.description+'</p>\n'+
    '<a id="buy" href="#" type="button">Buy</a>\n' +       
    '</div>\n' +
    '<br/>';
    const lcontainer=document.getElementById("main");
    lcontainer.innerHTML+=innerhtml;
};

   const data=[{
    brand:'A',
    img: './resources/t1.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'C',
    img: './resources/t2.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'B',
    img: './resources/t3.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'A',
    img: './resources/t4.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'C',
    img: './resources/t5.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'C',
    img: './resources/t6.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'A',
    img: './resources/t21.webp',
    name: 'T-Shirt',
    description: 'Description'},
{
    brand:'B',
    img: './resources/t22.webp',
    name: 'T-Shirt',
    description: 'Description'
},
{
    brand:'B',
    img: './resources/Tshirt.webp',
    name: 'T-Shirt',
    description: 'Description'
}
];
   
function iterate(){
    for(let i=0;i<data.length;i++){
        let order=data[i];
        addItemCard(order);
    }
}

iterate();
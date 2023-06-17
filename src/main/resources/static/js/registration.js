const submitBtn = document.querySelector('.submit-btn');
const block = document.querySelector('.block');
const closeButton = document.querySelector('.close-button');
const modalWindow = document.querySelector('.er');

setTimeout(function () {
  block.classList.add('open')
}, 1000)

/// дизайн кнопки сабмит
// submitBtn.addEventListener('click', function() {
//   submitBtn.textContent = 'отправлено'
//   submitBtn.classList.add('succes')
//   setTimeout(2000, ()=> {
//     submitBtn.textContent = 'Отправить'
//     submitBtn.classList.remove('succes')
//  })
// })






closeButton.addEventListener('click', ()=> {
 setTimeout(modalWindow.classList.remove('open'),  5000)

})
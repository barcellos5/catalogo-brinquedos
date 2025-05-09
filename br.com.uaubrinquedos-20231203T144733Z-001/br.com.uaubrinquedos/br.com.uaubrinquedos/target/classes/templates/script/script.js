function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    sidebar.style.display = (sidebar.style.display === 'none' || sidebar.style.display === '') ? 'block' : 'none';
  }

/*  function toggleSubmenu(submenuId) {
    var submenu = document.getElementById(submenuId + 'SubMenu');
    submenu.style.display = (submenu.style.display === 'none') ? 'block' : 'none';
  }*/

  function carregarGaleria(categoria) {
    /* Lógica para carregar a galeria da categoria selecionada deve ser inserida aqui:
        é preciso verifir como seram carregadas essas informações e serão atraves de uma chamada do código de listagem da classe java*/
    alert('Carregar galeria da categoria: ' + categoria);
  }
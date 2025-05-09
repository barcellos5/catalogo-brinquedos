function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    sidebar.style.display = (sidebar.style.display === 'none' || sidebar.style.display === '') ? 'block' : 'none';
  }

/*  function toggleSubmenu(submenuId) {
    var submenu = document.getElementById(submenuId + 'SubMenu');
    submenu.style.display = (submenu.style.display === 'none') ? 'block' : 'none';
  }*/

  function carregarGaleria(categoria) {
    // informa uma API para interagir com o MongoDB
    const url = `br.com.uaubrinquedos/categorias/${categoria}`;
  
    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na solicitação: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        // Processãndo os dados recebidos do banco de dados
        console.log('catalogoBrinquedo1:', data);
        // chamando a proxima função para manipular a galeria
        exibirGaleria(data);
      })
      .catch(error => {
        console.error('Erro ao carregar galeria:', error.message);
      });
  }
  
    function exibirGaleria(data) {
      // data é o vetor com as informação recebidas do banco de dados
      const galleryDiv = document.querySelector('.product-gallery');

      // Limpa as informações exestentes
      galleryDiv.innerHTML = '';

      // Usa os dados e cria elementos em html
        data.forEach(product => {
            const productDiv = document.createElement('div');
            productDiv.classList.add('product');

            const productLink = document.createElement('a');
            productLink.href = 'detalhesprotuto.html'; // link para a pagina de detalhes de produtos

            const productName = document.createElement('h3');
            productName.textContent = product.name;

            const productImage = document.createElement('img');
            productImage.src = product.image;
            productImage.alt = product.name;

            const productDescription = document.createElement('p');
            productDescription.textContent = product.description;

            const productPrice = document.createElement('p');
            productPrice.textContent = `R$ ${product.price.toFixed(2)}`;

            // Anexa elementos do prduto
            productLink.appendChild(productName);
            productLink.appendChild(productImage);
            productLink.appendChild(productDescription);
            productLink.appendChild(productPrice);

            // Anexa o link do produto a div do produto
            productDiv.appendChild(productLink);

            // Anexa o div do produto à galeria
            galleryDiv.appendChild(productDiv);
      });  
      alert('Dados recebidos da base de dados.');
    }

    function alterarProduto() {
      var idProduto = document.getElementById("idProduto").value;
      var novasInformacoes = document.getElementById("novasInformacoes").value;

      
      alert("ID do Produto: " + idProduto + "\nNovas Informações: " + novasInformacoes);
    }

    function excluirProduto() {
      var idProdutoExcluir = document.getElementById("idProdutoExcluir").value;
      if (confirm("Tem certeza que deseja excluir o produto com o ID " + idProdutoExcluir + "?")) {
        // Lógica para exclusão do produto aqui (substitua com sua lógica real)
        alert("Produto excluído com sucesso!");
      }
    }

    function openTab(tabName) {
      // Esconde todos os conteúdos das abas
      var tabContents = document.getElementsByClassName('tab-content');
      for (var i = 0; i < tabContents.length; i++) {
        tabContents[i].classList.remove('active');
      }

      // Remove a classe 'active' de todas as abas
      var tabLinks = document.getElementsByClassName('tab-link');
      for (var i = 0; i < tabLinks.length; i++) {
        tabLinks[i].classList.remove('active');
      }

      // Exibe o conteúdo da aba clicada e marca a aba como ativa
      document.getElementById(tabName).classList.add('active');
      event.currentTarget.classList.add('active');
    }

    function submitForm() {
      // Implemente aqui a lógica para enviar o formulário
      alert('Formulário enviado!');
    }

    const produtos = [
      { id: 1, nome: 'Produto 1', descricao: 'Descrição do Produto 1', preço: 'Preço do produto 1', categoria: 'Categoria do produto 1'  },
      { id: 2, nome: 'Produto 2', descricao: 'Descrição do Produto 2', preço: 'Preço do produto 2', categoria: 'Categoria do produto 2'   },
  ];

  function listarProdutos() {
      const listaProdutosDiv = document.getElementById('listaProdutos');
      listaProdutosDiv.innerHTML = '';

      if (produtos.length > 0) {
          produtos.forEach(produto => {
              const produtoDiv = document.createElement('div');
              produtoDiv.classList.add('produto');
              produtoDiv.innerHTML = `
                  <p><strong>ID do Produto:</strong> ${produto.id}</p>
                  <p><strong>Nome do Produto:</strong> ${produto.nome}</p>
                  <p><strong>Descrição do Produto:</strong> ${produto.descricao}</p>
                  <p><strong>Preço do Produto:</strong> ${produto.preço}</p>
                  <p><strong>Categoria do Produto:</strong> ${produto.categoria}</p>
                  <hr>
              `;
              listaProdutosDiv.appendChild(produtoDiv);
          });
      } else {
          listaProdutosDiv.innerHTML = '<p>Nenhum produto encontrado.</p>';
      }
  }

      const produtos = [
        { id: 1, nome: 'Produto 1', descricao: 'Descrição do Produto 1', preço: 'Preço do produto 1', categoria: 'Categoria do produto 1'  },
    { id: 2, nome: 'Produto 2', descricao: 'Descrição do Produto 2', preço: 'Preço do produto 2', categoria: 'Categoria do produto 2'   },
    ];

    function pesquisarProduto() {
        const produtoId = document.getElementById('produtoId').value;
        const resultadoDiv = document.getElementById('resultado');
        resultadoDiv.innerHTML = '';

        const produtoEncontrado = produtos.find(produto => produto.id == produtoId);

        if (produtoEncontrado) {
            resultadoDiv.innerHTML = `
                <p><strong>ID do Produto:</strong> ${produtoEncontrado.id}</p>
                <p><strong>Nome do Produto:</strong> ${produtoEncontrado.nome}</p>
                <p><strong>Descrição do Produto:</strong> ${produtoEncontrado.descricao}</p>
                <p><strong>Preço do Produto:</strong> ${produtoEncontrado.preço}</p>
                <p><strong>Categoria do Produto:</strong> ${produtoEncontrado.categoria}</p>
            `;
        } else {
            resultadoDiv.innerHTML = '<p>Produto não encontrado.</p>';
        }
    }
    
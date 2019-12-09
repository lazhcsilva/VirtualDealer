$("#form_cliente").validate({
       rules : {
             nomeCliente:{
                    required:true,
                    minlength:3
					maxlength:20
             },
             emailCliente:{
                    required:true
             },
			 cpf{
					required:true
			 }
       },
       messages:{
             nomeCliente:{
                    required:"Por favor, informe seu nome",
                    minlength:"O nome deve ter pelo menos 3 caracteres"
             },
             emailCliente:{
                    required:"É necessário informar um email"
             },
			cpf:{
					required:"Digite um CPF válido"
			}
       }
});

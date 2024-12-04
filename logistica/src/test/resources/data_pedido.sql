
INSERT INTO logistica.item(
   ite_id, ite_descricao, ite_quantidade)
VALUES (995,'Produdo A', 2);

INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (996,'Produdo B', 2);


INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (997,'Produdo C', 2);

INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (998,'Produdo D', 2);


INSERT INTO pedido.pedidos(
    ped_id, ped_cidade_cliente, ped_cliente_integrado, ped_cpf_cliente, ped_data, ped_email_cliente, ped_endereco_cliente, ped_estoque_validado, ped_nome_cliente, pes_status)
VALUES (995, 'Sobral', false, '00522240313', current_date, 'teste@gmail.com',
        'Rua b', false, 'Teste', 'REALIZADO');

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 995);


INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 996);

INSERT INTO pedido.pedidos(
    ped_id, ped_cidade_cliente, ped_cliente_integrado, ped_cpf_cliente, ped_data, ped_email_cliente, ped_endereco_cliente, ped_estoque_validado, ped_nome_cliente, pes_status)
VALUES (996, 'Sobral', false, '00522240313', current_date, 'teste@gmail.com',
        'Rua b', false, 'Teste', 'REALIZADO');

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 997);

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 998);

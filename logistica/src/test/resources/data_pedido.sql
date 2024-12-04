
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

INSERT INTO logistica.pedido(
    ped_id, ped_cidade_cliente, ped_cpf_cliente, ped_data_entrada, ped_email_cliente, ped_endereco_cliente, ped_nome_cliente, ped_status, ent_id)
VALUES (995, 'Sobral', '00522240313', current_date, 'teste@gmail.com',
        'Teste', 'Teste', 'PRONTO',NULL);

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 995);


INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 996);

INSERT INTO logistica.pedido(
    ped_id, ped_cidade_cliente, ped_cpf_cliente, ped_data_entrada, ped_email_cliente, ped_endereco_cliente, ped_nome_cliente, ped_status, ent_id)
VALUES (996, 'Sobral', '00522240313', current_date, 'teste@gmail.com',
        'Teste', 'Teste', 'PRONTO',NULL);
INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 997);

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 998);

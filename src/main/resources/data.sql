CREATE SEQUENCE seq_projetos
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 10;

CREATE SEQUENCE seq_pessoa
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 10;

INSERT INTO
    PUBLIC.PESSOA(
    ID,
    NOME,
    PESSOA_COL)
VALUES(
        seq_pessoa.nextval,
       'FUNCIONARIO',
       seq_pessoa.currval

);
INSERT INTO
    PUBLIC.PESSOA(
    ID,
    NOME,
    PESSOA_COL)
VALUES(
          seq_pessoa.nextval,
          'GERENTE',
          seq_pessoa.currval

      );

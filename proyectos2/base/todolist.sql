PGDMP                         {            todolist    15.4    15.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16421    todolist    DATABASE     }   CREATE DATABASE todolist WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Bolivia.1252';
    DROP DATABASE todolist;
                postgres    false            �            1259    24624 	   etiquetas    TABLE     S   CREATE TABLE public.etiquetas (
    id "char" NOT NULL,
    nometiquetas "char"
);
    DROP TABLE public.etiquetas;
       public         heap    postgres    false            �            1259    24619    tarea    TABLE     n   CREATE TABLE public.tarea (
    id "char" NOT NULL,
    nombre "char",
    fecha date,
    etiqueta "char"
);
    DROP TABLE public.tarea;
       public         heap    postgres    false            �            1259    24611    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id "char" NOT NULL,
    "nombreUsuario" "char",
    "contraseña" "char",
    nombre "char",
    apellido "char"
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false                      0    24624 	   etiquetas 
   TABLE DATA           5   COPY public.etiquetas (id, nometiquetas) FROM stdin;
    public          postgres    false    216   m                 0    24619    tarea 
   TABLE DATA           <   COPY public.tarea (id, nombre, fecha, etiqueta) FROM stdin;
    public          postgres    false    215   �                  0    24611    usuarios 
   TABLE DATA           X   COPY public.usuarios (id, "nombreUsuario", "contraseña", nombre, apellido) FROM stdin;
    public          postgres    false    214   �       q           2606    24628    etiquetas etiquetas_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.etiquetas
    ADD CONSTRAINT etiquetas_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.etiquetas DROP CONSTRAINT etiquetas_pkey;
       public            postgres    false    216            o           2606    24623    tarea tarea_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_pkey;
       public            postgres    false    215            m           2606    24615    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    214                  x�3�,�2�L�2������� ��         /   x�3�L�4202�54"�d.#���q�ps� TU��qqq o	�          4   x�3���4�d.# 	�U\Ɯ�@V"g.�	g6''r�r&s�q	W� |	�     
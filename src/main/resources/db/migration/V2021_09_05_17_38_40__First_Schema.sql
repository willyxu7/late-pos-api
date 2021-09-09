CREATE TABLE operators (
    id varchar(36) not null,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    pin int,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);

CREATE TABLE customers (
    id varchar(36) not null,
    name varchar(255) not null,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);

CREATE TABLE categories (
    id varchar(36) not null,
    name varchar(255) not null,
    description text null,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);

CREATE TABLE products (
    id varchar(36) not null,
    category_id varchar(36) not null references categories (id),
    name varchar(255) not null,
    description text null,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);

CREATE TABLE variants (
    id varchar(36) not null,
    product_id varchar(36) not null references products (id),
    name varchar(255) not null,
    price numeric(19, 2) not null check (price>=0),
    sku varchar(255),
    description varchar(255),
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),

    primary key (id)
);

CREATE TYPE shift_status AS ENUM('OPEN', 'CLOSE');

CREATE TABLE shifts (
    id varchar(36) not null,
    operator_id varchar(36) not null references operators (id),
    beginning_balance decimal(16, 8),
    ending_balance decimal(16, 8),
    beginning_time time not null,
    ending_time time null,
    beginning_date date not null,
    ending_date date null,
    status shift_status,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),

    primary key (id)
);

CREATE TABLE shift_details (
    id varchar(36) not null,
    shift_id varchar(36) not null references shifts (id),
    balance_in decimal(16, 8),
    balance_out decimal(16, 8),
    description text null,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),

    primary key (id)
);

CREATE TABLE sales (
    id varchar(36) not null,
    customer_id varchar(36) null references customers (id),
    code varchar(255),
    is_void boolean,
    subtotal decimal(16, 8),
    discount decimal(16, 8),
    total decimal(16, 8),
    note text,
    period time,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),

    primary key (id)
);

CREATE TABLE sale_details (
    id varchar(36) not null,
    sale_id varchar(36) not null references sales (id),
    product_id varchar(36) not null references products (id),
    price decimal(16, 8),
    quantity int,
    amount decimal(16, 8),
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),

    primary key (id)
);

CREATE TABLE sale_orders (
    id varchar(36) not null,
    sale_id varchar(36) null references sales (id),
    customer_id varchar(36) null references customers (id),
    code varchar(255),
    is_void boolean,
    subtotal decimal(16, 8),
    discount decimal(16, 8),
    total decimal(16, 8),
    note text,
    period time,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);

CREATE TABLE sale_order_details (
    id varchar(36) not null,
    sale_order_id varchar(36) not null references sales (id),
    product_id varchar(36) not null references products (id),
    price decimal(16, 8),
    quantity int,
    amount decimal(16, 8),
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255),
    deleted_at timestamp,
    deleted_by varchar(255),

    primary key (id)
);
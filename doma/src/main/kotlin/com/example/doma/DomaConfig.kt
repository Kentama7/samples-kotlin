package com.example.doma

import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.Naming
import org.seasar.doma.jdbc.dialect.H2Dialect
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import javax.sql.DataSource

object DomaConfig : Config {
    private val dialect = H2Dialect()

    private val dataSource = LocalTransactionDataSource(
        "jdbc:h2:mem:tutorial;DB_CLOSE_DELAY=-1", "sa", null)

    private val transactionManager = LocalTransactionManager(
        dataSource.getLocalTransaction(jdbcLogger))

    override fun getDialect(): H2Dialect = dialect

    override fun getDataSource(): DataSource = dataSource

    override fun getTransactionManager(): LocalTransactionManager = transactionManager

    override fun getNaming(): Naming = Naming.SNAKE_LOWER_CASE
}
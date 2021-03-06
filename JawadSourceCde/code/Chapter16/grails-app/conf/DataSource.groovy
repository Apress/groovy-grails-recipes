dataSource {
  pooled = false
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.provider_class = 'org.hibernate.cache.EhCacheProvider'
}
// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "create-drop" // one of 'create', 'create-drop','update'
    }
  }
  test {
    dataSource {
      dbCreate = "update"
    }
  }
  production {
    dataSource {
      dbCreate = "update"
    }
  }
}

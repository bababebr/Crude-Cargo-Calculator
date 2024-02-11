package com.ship4all.service.crude.util;

import com.ship4all.service.crude.exception.ModelNotFoundException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RepositoryUtils {

  public static <T, R> T findEntityOrThrow(Function<R, Optional<T>> finder, R id, String entityName) {
    return finder.apply(id).orElseThrow(() -> new ModelNotFoundException(entityName));
  }

  public static <T, R> T findEntityOrNull(Function<R, Optional<T>> finder, R id) {
    return finder.apply(id).orElse(null);
  }

  public static <T, U, R> T findEntityOrThrow(BiFunction<U, R, Optional<T>> finder, U entityId, R bindEntityId, String entityName) {
    return finder.apply(entityId, bindEntityId).orElseThrow(() -> new ModelNotFoundException(entityName));
  }

}
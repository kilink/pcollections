/*
 * Copyright (c) 2008 Harold Cooper. All rights reserved.
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/** */
package org.pcollections;

import java.util.Collection;
import java.util.Queue;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * A persistent queue.
 *
 * @author mtklein
 */
public interface PQueue<E> extends PCollection<E>, Queue<E> {
  /* Guaranteed to stay as a PQueue, i.e. guaranteed-fast methods */
  public PQueue<E> minus();

  public PQueue<E> plus(E e);

  public PQueue<E> plusAll(Collection<? extends E> list);

  /* May switch to other PCollection, i.e. may-be-slow methods */
  public PCollection<E> minus(Object e);

  public PCollection<E> minusAll(Collection<?> list);

  @Deprecated
  boolean offer(E o);

  @Deprecated
  E poll();

  @Deprecated
  E remove();

  @Override
  default Spliterator<E> spliterator() {
    return Spliterators.spliterator(this, Spliterator.IMMUTABLE | Spliterator.ORDERED);
  }
}

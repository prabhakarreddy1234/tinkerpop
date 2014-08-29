package com.tinkerpop.gremlin.process.util;

import com.tinkerpop.gremlin.process.Step;
import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.Traverser;
import com.tinkerpop.gremlin.process.computer.GraphComputer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EmptyTraversal<S, E> implements Traversal<S, E> {

    private static final EmptyTraversal INSTANCE = new EmptyTraversal();
    private static final SideEffects SIDE_EFFECTS = new DefaultSideEffects(EmptyTraversal.instance());
    private static final Strategies TRAVERSAL_STRATEGIES = new DefaultStrategies(EmptyTraversal.instance());

    public static EmptyTraversal instance() {
        return INSTANCE;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        throw FastNoSuchElementException.instance();
    }

    @Override
    public SideEffects sideEffects() {
        return SIDE_EFFECTS;
    }

    @Override
    public Strategies strategies() {
        return TRAVERSAL_STRATEGIES;
    }

    @Override
    public void addStarts(final Iterator<Traverser<S>> starts) {

    }

    @Override
    public <E2> Traversal<S, E2> addStep(final Step<?, E2> step) {
        return (Traversal) this;
    }

    @Override
    public List<Step> getSteps() {
        return Collections.emptyList();
    }

    @Override
    public Traversal<S, E> submit(final GraphComputer computer) {
        return INSTANCE;
    }
}

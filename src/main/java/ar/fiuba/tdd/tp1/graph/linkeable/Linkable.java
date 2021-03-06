package ar.fiuba.tdd.tp1.graph.linkeable;

import java.util.Set;

/*
*   Interface for objects that can be linked
 */
public interface Linkable {

    Set<String> getLinkingTokens();

    String getLinkingSymbol();

    void setLinkingTokens(Set<String> linkingTokens);

    void addLinkingToken(String token);
}
